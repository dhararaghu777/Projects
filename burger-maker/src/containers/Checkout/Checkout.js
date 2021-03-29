import React, {Component} from 'react';
import {Route,Redirect} from 'react-router-dom';
import CheckoutSummary from '../../components/Order/CheckoutSummary/CheckoutSummary';
import ContactData from './ContactData/ContactData';
import {connect} from 'react-redux';

class Checkout extends Component{

    componentDidMount(){

    }

    checkoutCancelledHandler=()=>{
        this.props.history.goBack();
    }

    checkoutContinuedHandler=()=>{
        this.props.history.replace('/checkout/contact-data');
    }

        render(){
            let summary=<Redirect to="/" />
            if(this.props.ings){
                const purchasedRedirect=this.props.purchased? <Redirect to="/" /> : null;
                summary=(
                    <div>
                        {purchasedRedirect}
                        <CheckoutSummary 
                        ingrediants={this.props.ings}
                        checkoutCancelled={this.checkoutCancelledHandler}
                        checkoutContinued={this.checkoutContinuedHandler}  />
                        <Route  path={this.props.match.url+'/contact-data'} 
                            component={ContactData} />
                    </div>
                )
            }
            return summary;
        }
    }


    const mapStateToProps=(state)=>{
        return{
            ings:state.burgerBuilder.ingrediants,
            purchased:state.order.purchased
        }
    }


export default connect(mapStateToProps)(Checkout);