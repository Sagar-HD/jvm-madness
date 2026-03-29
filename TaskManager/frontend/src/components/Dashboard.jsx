import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router';
import api from '../axios';
const Dashboard = () => {
    const navigate=useNavigate();
    const [user,setUser]=useState("");
    const [tasks,setTasks]=useState({});
    function handleLogout(){
        localStorage.removeItem("user");
navigate("/login");
    }
    useEffect(()=>{
console.log("hii in dash");

setUser(JSON.parse(localStorage.getItem("user")));

  async function fetchData() {
    try {
      const res = await api.get("/task");
      console.log(res.data);
    } catch (err) {
      console.log(err);
    }
  }

  fetchData();

    },[])
  return (
    <>
    <div>Dashboard</div>
    <button onClick={handleLogout}>logout</button>
    <h1>Hello {user?.name}</h1>
    </>
  )
}

export default Dashboard