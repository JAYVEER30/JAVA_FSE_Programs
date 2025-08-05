import React from "react";

const BlogDetails = ({ blogs }) => {
  return (
    <div>
      {blogs.length > 0 ? (
        blogs.map((blog, index) => (
          <div key={index}>
            <h2>{blog.title}</h2>
            <h4>{blog.author}</h4>
            <p>{blog.description}</p>
          </div>
        ))
      ) : (
        <p>No blog content available</p>
      )}
    </div>
  );
};

export default BlogDetails;
