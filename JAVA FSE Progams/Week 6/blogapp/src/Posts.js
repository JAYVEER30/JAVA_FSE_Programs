import React, { Component } from 'react';
import Post from './Post';

class Posts extends Component {
  constructor(props) {
    super(props);
    this.state = {
      posts: [],
    };
  }

  // Fetch posts using Fetch API
  loadPosts = () => {
    fetch('https://jsonplaceholder.typicode.com/posts')
      .then(response => {
        if (!response.ok) {
          throw new Error('Failed to fetch posts');
        }
        return response.json();
      })
      .then(data => {
        this.setState({ posts: data });
      })
      .catch(error => {
        console.error('Error loading posts:', error);
        // You could throw error here to trigger componentDidCatch
        throw error;
      });
  };

  // Lifecycle hook
  componentDidMount() {
    this.loadPosts();
  }

  // Error boundary method
  componentDidCatch(error, info) {
    alert("An error occurred: " + error.message);
    console.log("Error Info:", info);
  }

  // Render method
  render() {
    return (
      <div>
        {this.state.posts.map(post => (
          <Post key={post.id} title={post.title} body={post.body} />
        ))}
      </div>
    );
  }
}

export default Posts;
