import React from 'react';
import classes from './Navbar.module.css';
import {withRouter,NavLink} from 'react-router-dom';
import {useState} from 'react';

 const Navbar=(props)=>{

    const [state, setstate] = useState({
        toggle:false
    });


     const updateHandler=()=>{
         setstate({
             toggle:!state.toggle
         });

     }

    let navBarToggler=null;
    if(state.toggle){
        navBarToggler=(
            <div className={classes.TogglePage}>
                <div className={classes.div}>
                    {props.match.url!=='/' ? 
                    <div className={classes.childDiv}>
                    <NavLink to="/" 
                            className={classes.NavLinks} >Home</NavLink>
                    </div> : null}
                    {props.match.url!=='/contact' ? 
                    <div className={classes.childDiv}>
                    <NavLink to="/contact" 
                            className={classes.NavLinks} >Contact</NavLink>
                    </div> : null}
                    {props.match.url!=='/resume' ? 
                    <div className={classes.childDiv}>
                    <NavLink to="/resume" 
                            className={classes.NavLinks} >Resume</NavLink>
                    </div> : null}
                    
                </div>
            </div>
        )
    }
    
    return (
        
        <div className={classes.Navbar}>
            <nav >
                <ul className={classes.ul}>
                    <li className={classes.li1}>Raghu Dara</li>
                    {props.match.url!=='/resume' ?
                            <li className={classes.li}>
                                <NavLink to="/resume"
                                    className={classes.NavLinks} >Resume</NavLink>
                            </li> : null}
                    {props.match.url!=='/contact' ?
                            <li className={classes.li}>
                                <NavLink to="/contact" 
                                    className={classes.NavLinks} >Contact</NavLink>
                            </li>: null}
                    
                    {props.match.url!=='/' ?
                        <li className={classes.li} >
                        <NavLink to="/" 
                            className={classes.NavLinks} >Home</NavLink>
                        </li> : null}
                    
                </ul>
                <ul className={classes.ul1}>
                    <li className={classes.li1}>Raghu Dara</li>
                    <li className={classes.li}>
                        <div className={classes.dashbar}
                             onClick={updateHandler}>
                            <div className={classes.div1}></div>
                            <div className={classes.div1}></div>
                            <div className={classes.div1}></div>
                        </div>
                    </li>
                    {state.toggle? navBarToggler:null}
                </ul>

            </nav>
        </div>

           
    )
}

export default withRouter(Navbar);
