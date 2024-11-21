import axios from 'axios';

export const fetchProducts = async () => {
  try {
    const response = await axios.get('http://localhost:3000/product');
    return response.data;
  } catch (error) {
    console.error('Error fetching product data:', error);
    return [];
  }
};
