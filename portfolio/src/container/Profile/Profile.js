import React from 'react';
import Navbar from '../../components/Navbar/Navbar';
import MainSection from '../../components/MainSection/MainSection';
// import backgroundImage from '../../Images/cool-background.svg';
import classes from './Profile.module.css';

const profile=()=>{
    return(
        <div className={classes.Profile}>
            <Navbar />
            <MainSection />
        </div>
        
    )
}

export default profile;