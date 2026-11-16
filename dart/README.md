# Relative Time Formatter API - Dart/Flutter Client

Relative Time Formatter converts Unix timestamps and ISO dates into readable relative time phrases. Choose between short, long, or abbreviated styles to get humanized past or future strings, millisecond differences, and unit breakdowns from seconds to years.

[![pub package](https://img.shields.io/pub/v/apiverve_relativetimeformatter.svg)](https://pub.dev/packages/apiverve_relativetimeformatter)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is the Dart/Flutter client for the [Relative Time Formatter API](https://apiverve.com/marketplace/relativetimeformatter?utm_source=dart&utm_medium=referral&utm_content=readme).

## Installation

Add this to your `pubspec.yaml`:

```yaml
dependencies:
  apiverve_relativetimeformatter: ^1.2.6
```

Then run:

```bash
dart pub get
# or for Flutter
flutter pub get
```

## Usage

```dart
import 'package:apiverve_relativetimeformatter/apiverve_relativetimeformatter.dart';

void main() async {
  final client = RelativetimeformatterClient('YOUR_API_KEY');

  try {
    final response = await client.execute({
      'timestamp': '1609459200',
      'reference': '2024-06-01T00:00:00Z',
      'style': 'short'
    });

    print('Status: ${response.status}');
    print('Data: ${response.data}');
  } catch (e) {
    print('Error: $e');
  }
}
```

## Response

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

## API Reference

- **API Home:** [Relative Time Formatter API](https://apiverve.com/marketplace/relativetimeformatter?utm_source=dart&utm_medium=referral&utm_content=readme)
- **Documentation:** [docs.apiverve.com/ref/relativetimeformatter](https://docs.apiverve.com/ref/relativetimeformatter?utm_source=dart&utm_medium=referral&utm_content=readme)

## Authentication

All requests require an API key. Get yours at [apiverve.com](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme).

## License

MIT License - see [LICENSE](LICENSE) for details.

---

Built with Dart for [APIVerve](https://apiverve.com?utm_source=dart&utm_medium=referral&utm_content=readme)
