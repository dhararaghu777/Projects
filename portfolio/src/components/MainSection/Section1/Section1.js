import React from 'react';
import classes from './Section1.module.css';
import Picture from '../../../Images/Raghu-dara.jpg';
// import pic1 from '../../../Images/background2.jpg';

const section1=()=>{
    return (
        <div className={classes.Section1}  >
           <div className={classes.PictureDiv}>
               <img className={classes.Picture} src={Picture} alt="" />
           </div>
           <div className={classes.Content}>
               <p>Hi..!</p>
               <h3><b>I'm Raghu Dara</b></h3>
               <p>Coder..!</p>
           </div>
        </div>
    )
}

export default section1;