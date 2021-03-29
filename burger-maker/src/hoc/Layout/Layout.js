import React,{Component} from 'react';
import Auxilary from '../Auxilary/Auxilary';
import classes from './Layout.module.css';
import Toolbar from '../../components/Navigation/Toolbar/Toolbar';
import SideDrawer from '../../components/SideDrawer/SideDrawer';

class Layout extends Component{

    state={
        showSideDrawer:false
    }

    sideDrawerClosedHandler=()=>{
        this.setState((prevState)=>{
            return {showSideDrawer:!prevState.showSideDrawer}
        })
    }

    sideDrawerToggleHandler=()=>{
        this.setState((prevState)=>{
            return {showSideDrawer:!prevState.showSideDrawer}
        })
    }

    render(){
        return(
            <Auxilary>
                <Toolbar 
                    drawerToggleClicked={this.sideDrawerToggleHandler} /> 
                <SideDrawer open={this.state.showSideDrawer} 
                            closed={this.sideDrawerClosedHandler}/>
                <main className={classes.Content}>
                    {this.props.children}
                </main>
            </Auxilary>
        )
    }
}

export default Layout;