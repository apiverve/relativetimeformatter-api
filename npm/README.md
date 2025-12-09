# Relative Time Formatter API

Relative Time Formatter is a tool for converting timestamps and dates to human-readable relative time formats like '2 hours ago' or 'in 3 days'. It supports multiple styles and custom reference times for flexible time representation.

![Build Status](https://img.shields.io/badge/build-passing-green)
![Code Climate](https://img.shields.io/badge/maintainability-B-purple)
![Prod Ready](https://img.shields.io/badge/production-ready-blue)

This is a Javascript Wrapper for the [Relative Time Formatter API](https://apiverve.com/marketplace/relativetimeformatter)

---

## Installation

Using npm:
```shell
npm install @apiverve/relativetimeformatter
```

Using yarn:
```shell
yarn add @apiverve/relativetimeformatter
```

---

## Configuration

Before using the Relative Time Formatter API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com)

---

## Quick Start

[Get started with the Quick Start Guide](https://docs.apiverve.com/quickstart)

The Relative Time Formatter API documentation is found here: [https://docs.apiverve.com/ref/relativetimeformatter](https://docs.apiverve.com/ref/relativetimeformatter).
You can find parameters, example responses, and status codes documented here.

### Setup

```javascript
const relativetimeformatterAPI = require('@apiverve/relativetimeformatter');
const api = new relativetimeformatterAPI({
    api_key: '[YOUR_API_KEY]'
});
```

---

## Usage

---

### Perform Request

Using the API is simple. All you have to do is make a request. The API will return a response with the data you requested.

```javascript
var query = {
  timestamp: "1609459200",
  date: "2024-01-01T00:00:00Z",
  reference: "2024-06-01T00:00:00Z",
  style: "short"
};

api.execute(query, function (error, data) {
    if (error) {
        return console.error(error);
    } else {
        console.log(data);
    }
});
```

---

### Using Promises

You can also use promises to make requests. The API returns a promise that you can use to handle the response.

```javascript
var query = {
  timestamp: "1609459200",
  date: "2024-01-01T00:00:00Z",
  reference: "2024-06-01T00:00:00Z",
  style: "short"
};

api.execute(query)
    .then(data => {
        console.log(data);
    })
    .catch(error => {
        console.error(error);
    });
```

---

### Using Async/Await

You can also use async/await to make requests. The API returns a promise that you can use to handle the response.

```javascript
async function makeRequest() {
    var query = {
  timestamp: "1609459200",
  date: "2024-01-01T00:00:00Z",
  reference: "2024-06-01T00:00:00Z",
  style: "short"
};

    try {
        const data = await api.execute(query);
        console.log(data);
    } catch (error) {
        console.error(error);
    }
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

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact).

---

## Updates

Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms) and all legal documents and agreements.

---

## License
Licensed under the The MIT License (MIT)

Copyright (&copy;) 2025 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
