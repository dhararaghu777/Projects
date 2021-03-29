import React from 'react';
import resume from '../../../Images/Resume.pdf';
import classes from  './Resume.module.css';

const Resume=()=>{
    return (
        <div >
            {/* <iframe src={resume} type="application/pdf" 
             title="resume"
             className={classes.Resume} ></iframe> */}
             <object data={resume} type="application/pdf" className={classes.Resume}>
             <h4 >Please view resume using web-view</h4>
            </object>
        </div>
    )
}

export default Resume;