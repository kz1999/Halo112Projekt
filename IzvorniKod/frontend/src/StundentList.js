import React from "react";
import Student from "./Student";
import './styles/StudentList.css'

function StudentList(){

    const [students, setStudents] = React.useState([]);
    {/*
    React.useEffect(()=>{
        fetch("http://localhost:8080/korisnici")
        .then(data => data.json())
        .then(students => setStudents(students))
    }, []);
    */}
    return(
        <div>
            {/*
            { students.map(student => <Student key={student.jmbag} student = {student}/>)}
            */}
        </div>
    )
}

export default StudentList;