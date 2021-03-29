import React from 'react';
import classes from './Order.module.css';

const order=(props)=>{

    let ingrediants=[];
    for(let ingrediant in props.ingrediants){
        ingrediants.push({
            name:ingrediant,
            amount:props.ingrediants[ingrediant]
        })
    }
    let ingrediantsOutput=ingrediants.map((ig)=>{
        return <spam key={ig.name }
                     style={{textTransform:'capitalize',
                             display:"inline-block",
                             margin:'0 8px',
                             border:'1px solid #ccc',
                             padding:'5px'}}>{ig.name} ({ig.amount})</spam>
    })

    return(
        <div className={classes.Order}>
            <p>ingrediants : {ingrediantsOutput}</p>
            <p>Price : <strong>Rs {props.price}</strong></p>
        </div>
    )
}

export default order;