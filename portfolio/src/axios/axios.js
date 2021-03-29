import React from 'react';
import axios from 'axios'

const instance = axios.create({
    baseURL: 'https://my-portfolio-f0c01-default-rtdb.firebaseio.com'
    
  });

  export default instance;