import React from 'react'
import { useState } from 'react';
import api from '../axios';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
const Login = () => {
 const navigate=useNavigate();
    const [email,setEmail]=useState("");
     const [password,setPassword]=useState("");
       const [formData, setFormData] = useState({
    email: '',
    password: '',
   
  })
    async function loginForm(e){
       e.preventDefault();
       console.log("trying to submit form");
      
       const res=await api.post("/login",formData)
       console.log(res);
       if(res.data.success){
         alert("login sucess");
        console.log(res.data.user);
        localStorage.setItem("user",JSON.stringify(res.data.user));
navigate("/dashboard");

       }
       else{
        alert("inavlid creds");
       }
    }
  return (
    <>
   <div className='login '>
<form className='w-1/2  border-4 border-amber-800  m-auto mt-7 rounded-2xl p-7 flex flex-col gap-5 justify-between items-center'  onSubmit={loginForm} >

email:<input   onChange={(e)=>{
  const value = e.target.value;
  setEmail(value);
  setFormData(prev => ({ ...prev, email: value }));
}} value={email}  className="w-1/2 border border-amber-500 rounded-xl" type="email" name="email"  />
password:<input className='w-1/2 border border-amber-500 rounded-xl' onChange={(e)=>{
  const value = e.target.value;
  setPassword(value);
  setFormData(prev => ({ ...prev, password: value }));
}}  value={password} type="password" name="password" id="" />
<div>
<button type="submit" className='bg-blue-600 text-white border border-white rounded-2xl  px-6 py-3'>submit</button>
<p><Link to={"/"}>dont have an account Register</Link></p>
</div>
</form>
   </div>
</>
  )
}

export default Login