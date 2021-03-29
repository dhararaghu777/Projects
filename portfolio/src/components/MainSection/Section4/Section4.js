import React from 'react';
import classes from './Section4.module.css';
import pic1 from '../../../Images/education.png';
import pic2 from '../../../Images/address.png';
import pic3 from '../../../Images/email.png';
import pic4 from '../../../Images/instagram.png';
import pic5 from '../../../Images/linkedIn.png';
import pic6 from '../../../Images/github.png';
import {Container,Row,Col,Button} from 'react-bootstrap';

const section4=()=>{
    return(
        <div className={classes.Section4}>
           <div className={classes.heading}>
                <h4>Bio Data</h4>  
            </div>
           <div className={classes.Details1}>
                <Container>
                    <Row>
                        <Col>
                            <a href="https://www.jntuacek.ac.in/" alt="" target="_blank" rel="noreferrer"><img className={classes.img1} src={pic1} alt="" /></a>
                            <p>Education</p> 
                        </Col>
                        <Col>
                            <a href="https://www.google.co.in/maps/place/13%C2%B037'06.3%22N+79%C2%B024'45.3%22E/@13.6195546,79.4129011,18.23z/data=!4m14!1m7!3m6!1s0x3a4d4b12525e4a95:0x25ff6c584c21962a!2sNew+Balaji+Colony,+Tirupati,+Andhra+Pradesh+517501!3b1!8m2!3d13.6195171!4d79.4155285!3m5!1s0x3a4d4b12c9a377a3:0x17b0e5c027c3a6ec!7e2!8m2!3d13.6184284!4d79.412572" alt="" target="_blank" rel="noreferrer"><img className={classes.img1} src={pic2} alt="" /></a>
                            <p>Address</p> 
                        </Col>
                    </Row>
                </Container>
           </div>
           <div className={classes.Details2}>
                <Container>
                    <Row>
                        <Col>
                            <a href="mailto:dhararaghu777@gmail.com" alt="" target="_blank" rel="noreferrer"><img className={classes.img2} src={pic3} alt="" /></a>
                            
                        </Col>
                        <Col>
                            <a href="https://www.instagram.com/raghu_dara/" alt="" target="_blank" rel="noreferrer"><img className={classes.img2} src={pic4} alt="" /></a>
                            
                        </Col>
                        <Col>
                            <a href="https://www.linkedin.com/in/raghu-dara-202" alt="" target="_blank" rel="noreferrer"><img className={classes.img2} src={pic5} alt="" /></a>
                            
                        </Col>
                        <Col>
                            <a href="https://github.com/dhararaghu777" alt="" target="_blank" rel="noreferrer"><img className={classes.img2} src={pic6} alt="" /></a>
                            
                        </Col>
                    </Row>
                </Container>
           </div>
           
        </div>
    )
}

export default section4;
