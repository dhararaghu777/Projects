import React from 'react';
import classes from './Icons.module.css';
import {Container,Row,Col} from 'react-bootstrap';

const icons=(props)=>{

    console.log(props);

    return (
        <Container>
            <Row>
                {props.details.map(x=>{
                  return  <Col className={classes.Icons}>
                            <img className={classes.image} src={x.image} alt="" />
                            <p>{x.name}</p>
                        </Col>
            })}
            </Row>
        </Container>
    )
}
export default icons;