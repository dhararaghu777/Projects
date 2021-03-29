import React from 'react';
import classes from './Section2.module.css';
import reactImage from '../../../Images/React.png';
import java from '../../../Images/java.png';
import javascript from '../../../Images/javascript.png';
import Icons from '../../UI/Icons/Icons';
import {Button} from 'react-bootstrap';
import {withRouter} from 'react-router-dom';

const section2=(props)=>{

    const icons=[
        {name:"React.Js", image:reactImage},
        {name:"Javascript", image:javascript},
        {name:"Java", image:java}
    ]

    console.log(props);
    const onClickHandler=()=>{
        props.history.push(props.match.url+"languages");
    }

    return (
        <div className={classes.Section2} >
            <div><h4>Talent in Languages...!</h4></div>
            <div className={classes.List}>
                <Icons  details={icons} />  
            </div>
            <div className={classes.button} >
                <Button variant="outline-info" onClick={onClickHandler}>Show More</Button>
            </div>
        </div>
    )
}

export default withRouter(section2);