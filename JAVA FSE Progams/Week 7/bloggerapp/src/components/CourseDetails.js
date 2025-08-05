import React from "react";

const CourseDetails = ({ courses }) => {
  return (
    <div>
      {courses.map((course, index) => (
        <div key={index}>
          <h2>{course.name}</h2>
          {course.date && <p>{course.date}</p>}
        </div>
      ))}
    </div>
  );
};

export default CourseDetails;
