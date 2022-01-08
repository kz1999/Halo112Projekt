import React from "react";
import '../styles/App.css';

function Member(props){
    const [member, setMember] = React.useState([]);
    const [user, setUser] = React.useState([]);

    React.useEffect(()=>{
        fetch('/spasioci/'+props.memberId)
        .then(data => data.json())
        .then(data => setMember(data));
    }, []);

    return(
        <option value={member.id}className="Member">{member.userName}</option>
    )
}


export default Member;