package com.dpc.algorithm.leetcode;

import java.util.*;
/*
* 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
1. postTweet(userId, tweetId): 创建一条新的推文
2. getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
3. follow(followerId, followeeId): 关注一个用户
4. unfollow(followerId, followeeId): 取消关注一个用户

示例:
* Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
twitter.getNewsFeed(1);

// 用户1关注了用户2.
twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
twitter.getNewsFeed(1);

* */


class Twitter {

    public static int interval = 0;

    static class Post {
        int id;
        long timeStamp;

        public Post(int postId) {
            this.id = postId;
            this.timeStamp = System.currentTimeMillis() + Twitter.interval++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Post post = (Post) o;
            return id == post.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, timeStamp);
        }
    }

    static class User {
        int id;
        LinkedList<Post> posts;
        Map<Integer, Post> index;
        Set<Integer> followers;

        private List<Integer> getFollowers() {
            List<Integer> res = new ArrayList<>(followers);
            if (!followers.contains(this.id)) {
                res.add(this.id);
            }
            return res;
        }

        private User(int userId) {
            this.id = userId;
            posts = new LinkedList<>();
            followers = new HashSet<>();
            index = new HashMap<>();
            followers.add(userId);
        }

        private void psotTweet(int tweetId) {
            if (!index.containsKey(tweetId)) {
                Post post = new Post(tweetId);
                posts.addFirst(post);
                index.put(tweetId, post);
            }
        }

        // 获取自己的最近10篇tweet
        private List<Post> getNeesFeed() {
            List<Post> res = new ArrayList<>(10);
            for (int i = 0; i < posts.size() && i < 10; i++) {
                res.add(posts.get(i));
            }
            return res;
        }

        private void follow(int followeeId) {
            followers.add(followeeId);
        }

        private void unfollow(int followeeId) {
            followers.remove(followeeId);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", followers=" + followers +
                    '}';
        }
    }

    private HashMap<Integer, User> users;

    /**
     * Initialize your data structure here.
     */
    public Twitter() {
        this.users = new HashMap<>();
    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) {
            // 初始化用户，并创建博客
            User user = new User(userId);
            users.put(userId, user);
        }
        users.get(userId).psotTweet(tweetId);
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) return new ArrayList<>();
        else {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Post> tempRes = new PriorityQueue<>(new Comparator<Post>() {
                @Override
                public int compare(Post o1, Post o2) {
//                    System.out.println(o1.timeStamp);
//                    System.out.println(o2.timeStamp);
                    int diff = (int) (o1.timeStamp - o2.timeStamp);
//                    System.out.println("diff" + diff);
                    return diff;
                }
            });
            User user = users.get(userId);
            List<Post> posts = new ArrayList<>();
            for (int followeeId : user.getFollowers()) {
                User followee = users.get(followeeId);
                posts.addAll(followee.getNeesFeed());
            }
            for (Post post : posts) {
                if (tempRes.size() != 10) tempRes.offer(post);
                else {
                    Post min = tempRes.peek();
                    if (min.timeStamp < post.timeStamp) {
                        tempRes.poll();
                        tempRes.offer(post);
                    }
                }
            }
            while (!tempRes.isEmpty()) {
                Post post = tempRes.poll();
                res.add(post.id);
            }
            Collections.reverse(res);
            return res;
        }
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            // 初始化用户，并创建博客
            User user = new User(followerId);
            users.put(followerId, user);
        }

        if (!users.containsKey(followeeId)) {
            // 初始化用户，并创建博客
            User user = new User(followeeId);
            users.put(followeeId, user);
        }

        User follower = users.get(followerId);

        follower.follow(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (users.containsKey(followerId) && users.containsKey(followeeId)) {
            User user = users.get(followerId);
            user.unfollow(followeeId);
        }
    }

    public static void main(String[] args) {
//

        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.unfollow(2, 2);

    }

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */


