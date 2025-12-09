/**
 * Basic Example - Relative Time Formatter API
 *
 * This example demonstrates how to use the Relative Time Formatter API.
 * Make sure to set your API key in the .env file or replace '[YOUR_API_KEY]' below.
 */

require('dotenv').config();
const relativetimeformatterAPI = require('../index.js');

// Initialize the API client
const api = new relativetimeformatterAPI({
    api_key: process.env.API_KEY || '[YOUR_API_KEY]'
});

// Example query
var query = {
  timestamp: "1609459200",
  date: "2024-01-01T00:00:00Z",
  reference: "2024-06-01T00:00:00Z",
  style: "short"
};

// Make the API request using callback
console.log('Making request to Relative Time Formatter API...\n');

api.execute(query, function (error, data) {
    if (error) {
        console.error('Error occurred:');
        if (error.error) {
            console.error('Message:', error.error);
            console.error('Status:', error.status);
        } else {
            console.error(JSON.stringify(error, null, 2));
        }
        return;
    }

    console.log('Response:');
    console.log(JSON.stringify(data, null, 2));
});
