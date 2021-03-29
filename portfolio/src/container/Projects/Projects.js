import React from 'react';
 import classes from './Projects.module.css';
import Navbar from '../../components/Navbar/Navbar';
import { Col, Container,Row } from 'react-bootstrap';
import pic1 from '../../Images/burger.png';
import pic2 from '../../Images/loan1.png';
import pic3 from '../../Images/cricket.png';
import pic4 from '../../Images/instagram.png'

const projects=()=>{
    return (
        <div>
            <Navbar />
            <div className={classes.Projects}>
            <div className={classes.content}>Projects List</div>
            <Container>
                <Row className={classes.row}>
                    <Col>
                        <a href="https://github.com/dhararaghu777/Projects" 
                        alt="Projects" target="_blank"
                        rel="noreferrer">
                            <img src={pic1} alt="Burger Project" />
                            <p>Burger Maker</p>
                        </a>
                        
                    </Col>
                    <Col>
                        <a href="https://github.com/dhararaghu777/Projects" 
                        alt="Projects" target="_blank"
                        rel="noreferrer">
                            <img src={pic2} alt="Loan Application Project" />
                            <p>Loan Application</p>
                        </a>
                        
                    </Col>
                </Row>
                <Row className={classes.row}>
                    <Col>
                        <a href="https://github.com/dhararaghu777/Projects" 
                        alt="Projects" target="_blank"
                        rel="noreferrer">
                            <img src={pic3} alt="Cricket Team" />
                            <p>Cricket Team</p>
                        </a>
                        
                    </Col>
                    <Col>
                        <a href="https://github.com/dhararaghu777/Projects" 
                        alt="Projects" target="_blank"
                        rel="noreferrer">
                            <img src={pic4} alt="Instagram" />
                            <p>Instagram</p>
                        </a>

                    </Col>
                </Row>
            </Container>
            </div>
            
        </div>
    )
}

export default projects;