import React, { useState } from 'react'
import api from '../axios';
import { Link } from 'react-router-dom';
const Register = () => {
    
    const [userName,setUserName]=useState("");
    const [email,setEmail]=useState("");
     const [password,setPassword]=useState("");
       const [formData, setFormData] = useState({
    email: '',
    password: '',
    name:""
  })
    async function registerForm(e){
       e.preventDefault();
       console.log("trying to submit form");
      
       const res=await api.post("/register",formData)
       console.log(res);
    }
  return (
    <>
   <div className='register '>
<form className='w-1/2  border-4 border-amber-800  m-auto mt-7 rounded-2xl p-7 flex flex-col gap-5 justify-between items-center'  onSubmit={registerForm} >
name:<input onChange={(e)=>{
  const value = e.target.value;
  setUserName(value);
  setFormData(prev => ({ ...prev, name: value }));
}} value={userName}  className="w-1/2 border border-amber-500 rounded-xl" type="text" name="name"  />

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

</div>
</form>
<p className='m-auto '><Link to={"/login"}>already have an account Login</Link></p>
   </div>
</>
  )
}

export default Register