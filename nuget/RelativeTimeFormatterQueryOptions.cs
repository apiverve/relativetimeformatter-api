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
        /// Unix timestamp in seconds or milliseconds
        /// </summary>
        [JsonProperty("timestamp")]
        public string Timestamp { get; set; }

        /// <summary>
        /// Reference time to compare against (default: current time)
        /// </summary>
        [JsonProperty("reference")]
        public string Reference { get; set; }

        /// <summary>
        /// Output style
        /// </summary>
        [JsonProperty("style")]
        public string Style { get; set; }
    }
}
