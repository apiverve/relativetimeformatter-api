"""
Relative Time Formatter API - Basic Usage Example

This example demonstrates the basic usage of the Relative Time Formatter API.
API Documentation: https://docs.apiverve.com/ref/relativetimeformatter
"""

import os
import requests
import json

API_KEY = os.getenv('APIVERVE_API_KEY', 'YOUR_API_KEY_HERE')
API_URL = 'https://api.apiverve.com/v1/relativetimeformatter'

def call_relativetimeformatter_api():
    """
    Make a GET request to the Relative Time Formatter API
    """
    try:
        # Query parameters
        params &#x3D; {&#x27;timestamp&#x27;: &#x27;1609459200&#x27;, &#x27;date&#x27;: &#x27;2024-01-01T00:00:00Z&#x27;, &#x27;reference&#x27;: &#x27;2024-06-01T00:00:00Z&#x27;, &#x27;style&#x27;: &#x27;short&#x27;}

        headers = {
            'x-api-key': API_KEY
        }

        response = requests.get(API_URL, headers=headers, params=params)

        # Raise exception for HTTP errors
        response.raise_for_status()

        data = response.json()

        # Check API response status
        if data.get('status') == 'ok':
            print('✓ Success!')
            print('Response data:', json.dumps(data['data'], indent=2))
            return data['data']
        else:
            print('✗ API Error:', data.get('error', 'Unknown error'))
            return None

    except requests.exceptions.RequestException as e:
        print(f'✗ Request failed: {e}')
        return None

if __name__ == '__main__':
    print('📤 Calling Relative Time Formatter API...\n')

    result = call_relativetimeformatter_api()

    if result:
        print('\n📊 Final Result:')
        print(json.dumps(result, indent=2))
    else:
        print('\n✗ API call failed')
