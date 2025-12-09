using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.RelativeTimeFormatter
{
    /// <summary>
    /// Query options for the Relative Time Formatter API
    /// </summary>
    public class RelativeTimeFormatterQueryOptions
    {
        /// <summary>
        /// Unix timestamp in seconds or milliseconds (provide either timestamp or date)
        /// Example: 1609459200
        /// </summary>
        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }

        /// <summary>
        /// ISO date string (provide either timestamp or date)
        /// Example: 2024-01-01T00:00:00Z
        /// </summary>
        [JsonProperty("date")]
        public string Date { get; set; }

        /// <summary>
        /// Reference time to compare against (default: current time)
        /// Example: 2024-06-01T00:00:00Z
        /// </summary>
        [JsonProperty("reference")]
        public string Reference { get; set; }

        /// <summary>
        /// Output style: short, long, or abbreviated (default: short)
        /// Example: short
        /// </summary>
        [JsonProperty("style")]
        public string Style { get; set; }
    }
}
