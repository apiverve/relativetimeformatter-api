# Relative Time Formatter API - PHP Package

Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases. Choose between short, long, or abbreviated styles to get humanized past or future strings, millisecond differences, and unit breakdowns from seconds to years.

## Installation

Install via Composer:

```bash
composer require apiverve/relativetimeformatter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Relativetimeformatter\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'timestamp' => '1609459200',
    'reference' => '2024-06-01T00:00:00Z',
    'style' => 'short'
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Relativetimeformatter\Client;
use APIVerve\Relativetimeformatter\Exceptions\APIException;
use APIVerve\Relativetimeformatter\Exceptions\ValidationException;

try {
    $response = $client->execute(['timestamp' => '1609459200', 'reference' => '2024-06-01T00:00:00Z', 'style' => 'short']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "target_date": "2021-01-01T00:00:00Z",
    "reference_date": "2025-12-16T22:28:24.459Z",
    "relative_time": "4 years ago",
    "is_past": true,
    "is_future": false,
    "difference_ms": -156464904459,
    "primary_unit": "year",
    "primary_value": 4,
    "all_units": {
      "years": 4,
      "months": 59,
      "weeks": 258,
      "days": 1810,
      "hours": 43462,
      "minutes": 2607748,
      "seconds": 156464904,
      "milliseconds": 156464904459
    },
    "style": "short"
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/relativetimeformatter?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/relativetimeformatter?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/relativetimeformatter?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
