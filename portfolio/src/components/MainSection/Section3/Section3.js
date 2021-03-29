import React from 'react';
import classes from './Section3.module.css';
import {Button} from 'react-bootstrap';
import pic1 from '../../../Images/burger.png';
import pic2 from '../../../Images/loan1.png';
import pic3 from '../../../Images/instagram.png';
import pic4 from '../../../Images/cricket1.png';
import Slides from '../../UI/Slides/Slides';
import {withRouter} from 'react-router-dom';

const section3=(props)=>{
    const projectsList=[
        {pic:pic1,content:"Buger Builder"},
        {pic:pic2,content:"Loan Application"},
        {pic:pic3,content:"Instagram"},
        {pic:pic4,content:"Cricket Team"}
    ];

    const onClickHandler=()=>{
        props.history.push(props.match.url+"projects");
    }

    return (
        <div className={classes.Section3}>
            <div className={classes.content}>
                <h4>Projects List</h4>
            </div>
            <Slides projects={projectsList} />
            <div className={classes.button}>
                <Button variant="outline-dark" 
                        onClick={onClickHandler} >Show Projects</Button>
            </div>
        </div>
    )
}

export default withRouter(section3);