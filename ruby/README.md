# Relative Time Formatter API - Ruby Gem

Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases. Choose between short, long, or abbreviated styles to get humanized past or future strings, millisecond differences, and unit breakdowns from seconds to years.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_relativetimeformatter'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_relativetimeformatter
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_relativetimeformatter'

# Initialize the client
client = APIVerve::Relativetimeformatter::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({
  timestamp: "1609459200",
  reference: "2024-06-01T00:00:00Z",
  style: "short"
})

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ timestamp: "1609459200", reference: "2024-06-01T00:00:00Z", style: "short" })
  puts response["data"]
rescue APIVerve::Relativetimeformatter::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Relativetimeformatter::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Relativetimeformatter::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
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

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/relativetimeformatter?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/relativetimeformatter?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/relativetimeformatter?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
