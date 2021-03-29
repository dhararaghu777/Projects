import React, {Component} from 'react';
import Auxilary from '../../../hoc/Auxilary/Auxilary';
import Button from '../../UI/Button/Button';

class OrderSummary extends Component{



    render(){
        const ingrediantSummary=Object.keys(this.props.ingrediants)
            .map(igKey=>{
            return (
                <li key={igKey}>
                    <span style={{textTransform:'capitalize'}}>{igKey}</span> : {this.props.ingrediants[igKey]}
                </li>)        
            })

    return(
        <Auxilary>
            <h3>Your Order</h3>
            <p>A delicious burger with following ingredients:</p>
            <ul>
                {ingrediantSummary}
            </ul>
            <p><strong>Total Price : {this.props.price}</strong></p>
            <p>Continue to Checkout?</p>
            <Button btnType="Danger" 
                    clicked={this.props.purchaseCancelled}>CANCEL</Button>
            <Button btnType="Success" 
                    clicked={this.props.purchaseContinued}>CONTINUE</Button>
        </Auxilary>
    )
    }
}



export default OrderSummary;