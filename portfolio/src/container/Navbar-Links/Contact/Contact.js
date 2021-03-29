import classes from './Contact.module.css';
import React, { useState } from 'react';
import {Form, Button} from 'react-bootstrap';
import Navbar from "../../../components/Navbar/Navbar";
import axios from '../../../axios/axios';
import {withRouter} from 'react-router-dom';


const Contact=(props)=>{

    const [state,setState]=useState({
        email:'',
        user:'',
        phoneNumber:'',
        query:''
    });

    const onChangeHandler=(e)=>{
        const {name,value}=e.target;
        //console.log(name,value);
        const myState={...state};
        myState[name]=value;
       // console.log(myState,state);
        setState({
            ...myState
        });
        
    }

    const onSubmitHandler=(e)=>{
        e.preventDefault();
        const details={...state};
        console.log(details);
        
        axios.post('/customer.json',details).then((res)=>{
            console.log(res);
        }).catch(err=>{
            console.log(err);
        });

        setTimeout(()=>{  
         props.history.push('/');
        },1000);
        
    }

    return (
        <div>
            <Navbar />
            <div className={classes.Contact}>
                <Form>
                    <Form.Group controlId="formBasicEmail">
                        <Form.Label>Email address</Form.Label>
                        <Form.Control type="email" name='email' placeholder="Enter your email" onChange={onChangeHandler}  />

                        <Form.Label>Name</Form.Label>
                        <Form.Control type="text" name='user' placeholder="Enter your Name" onChange={onChangeHandler} />

                        <Form.Label>Contact Number</Form.Label>
                        <Form.Control type="text" placeholder="Enter your mobile number" name='phoneNumber' onChange={onChangeHandler} />

                        <Form.Label>Query</Form.Label>
                        <Form.Control as="textarea" placeholder="Mention here" name='query' onChange={onChangeHandler} />
                    </Form.Group>
                    <Button variant="primary" type="button" onClick={onSubmitHandler}>
                        Submit
                    </Button>
                </Form>
            </div>
            
        </div>
    )
}

export default withRouter(Contact);