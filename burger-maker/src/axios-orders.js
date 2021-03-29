import axios from 'axios';

const instance = axios.create({
    baseURL:"https://burger-maker-208f3-default-rtdb.firebaseio.com/"
})

export default instance;