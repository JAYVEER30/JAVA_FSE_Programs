import React from "react";
import BookDetails from "./components/BookDetails";
import BlogDetails from "./components/BlogDetails";
import CourseDetails from "./components/CourseDetails";
import { books } from "./data/books";
import './App.css';

function App() {
  const blogs = [
    {
      title: "React Learning",
      author: "Stephen Biz",
      description: "Welcome to learning React!",
    },
    {
      title: "Installation",
      author: "Schewzdenier",
      description: "You can install React from npm.",
    },
  ];

  const courses = [
    { name: "Angular", date: "4/5/2021" },
    { name: "React", date: "6/3/20201" }, // Typo in original screenshot
  ];

  const showBooks = true;
  const showBlogs = true;

  return (
    <div style={{ display: "flex", justifyContent: "space-around" }}>
      {showBooks && (
        <div className="st2">
          <h1>Book Details</h1>
          <BookDetails books={books} />
        </div>
      )}

      {showBlogs ? (
        <div className="v1">
          <h1>Blog Details</h1>
          <BlogDetails blogs={blogs} />
        </div>
      ) : (
        <p>No Blogs to Display</p>
      )}

      <div className="mystyle1">
        <h1>Course Details</h1>
        <CourseDetails courses={courses} />
      </div>
    </div>
  );
}

export default App;
