# Relative Time Formatter API - Go Client

Relative Time Formatter is a tool for converting timestamps and dates to human-readable relative time formats like '2 hours ago' or 'in 3 days'. It supports multiple styles and custom reference times for flexible time representation.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Go client for the [Relative Time Formatter API](https://apiverve.com/marketplace/relativetimeformatter?utm_source=go&utm_medium=readme)

---

## Installation

```bash
go get github.com/apiverve/relativetimeformatter-api/go
```

---

## Configuration

Before using the Relative Time Formatter API client, you need to obtain your API key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=go&utm_medium=readme)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart?utm_source=go&utm_medium=readme)

The Relative Time Formatter API documentation is found here: [https://docs.apiverve.com/ref/relativetimeformatter](https://docs.apiverve.com/ref/relativetimeformatter?utm_source=go&utm_medium=readme)

---

## Usage

```go
package main

import (
    "fmt"
    "log"

    "github.com/apiverve/relativetimeformatter-api/go"
)

func main() {
    // Create a new client
    client := relativetimeformatter.NewClient("YOUR_API_KEY")

    // Set up parameters
    params := map[string]interface{}{
        "timestamp": "1609459200",
        "reference": "now",
        "style": "short"
    }

    // Make the request
    response, err := client.Execute(params)
    if err != nil {
        log.Fatal(err)
    }

    fmt.Printf("Status: %s\n", response.Status)
    fmt.Printf("Data: %+v\n", response.Data)
}
```

---

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "target_date": "2021-01-01T00:00:00Z",
    "reference_date": "2025-11-15T05:18:30.831Z",
    "relative_time": "4 years ago",
    "is_past": true,
    "is_future": false,
    "difference_ms": -153724710831,
    "primary_unit": "year",
    "primary_value": 4,
    "all_units": {
      "years": 4,
      "months": 58,
      "weeks": 254,
      "days": 1779,
      "hours": 42701,
      "minutes": 2562078,
      "seconds": 153724710,
      "milliseconds": 153724710831
    },
    "style": "short"
  }
}
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=go&utm_medium=readme).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=go&utm_medium=readme), [Privacy Policy](https://apiverve.com/privacy?utm_source=go&utm_medium=readme), and [Refund Policy](https://apiverve.com/refund?utm_source=go&utm_medium=readme).

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
