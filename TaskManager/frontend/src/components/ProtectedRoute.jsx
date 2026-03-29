import React, { useEffect } from 'react'
import { Navigate, useNavigate } from 'react-router';

const ProtectedRoute = ({children}) => {
    const navigate=useNavigate();
    useEffect(()=>{
const user=JSON.parse(localStorage.getItem("user"));
if(user==null){
    console.log("unauthorized");
    navigate('/login');
}



    },[])
  return (

    <div>{children}</div>
  )
}

export default ProtectedRoute