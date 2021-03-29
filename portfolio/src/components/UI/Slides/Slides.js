import React from 'react';
import classes from './Slides.module.css';
import {Carousel} from 'react-bootstrap';

const slides=(props)=>{
    console.log(props);

    const slidesList=props.projects.map((x,id)=>
         (
        <Carousel.Item interval={1000} key={id}>
            <img
            className={`d-block w-50 ${classes.Image} `}
            src={x.pic}
            alt="First slide"
            />
            <Carousel.Caption>
            <h3 className={classes.h3}>{x.content}</h3>
            </Carousel.Caption>
        </Carousel.Item>
        )
    )

    return (
        <Carousel>{slidesList}</Carousel>
    )
}

export default slides;
