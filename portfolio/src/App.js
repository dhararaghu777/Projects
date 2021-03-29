import './App.css';
import Layout from './Layout/Layout';
import Langauges from './container/Langauges/Langauges'; 
import Projects from './container/Projects/Projects';
import Resume from './container/Navbar-Links/Resume/Resume';
import Contact from './container/Navbar-Links/Contact/Contact';
import {Route,Switch } from 'react-router-dom';


function App() {
  return (
    <div >
      <Switch>
        <Route path="/contact" component={Contact} />
        <Route path="/resume" component={Resume} />
        <Route path="/projects" component={Projects} />
        <Route path="/languages" component={Langauges} />
        <Route exact path="/" component={Layout} />
      </Switch>

    </div>
  );
}

export default App;
