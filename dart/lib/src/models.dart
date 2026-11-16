/// Response models for the Relative Time Formatter API.

/// API Response wrapper.
class RelativetimeformatterResponse {
  final String status;
  final dynamic error;
  final RelativetimeformatterData? data;

  /// Set only when the current plan locks one or more fields; null otherwise.
  final PremiumInfo? premium;

  RelativetimeformatterResponse({
    required this.status,
    this.error,
    this.data,
    this.premium,
  });

  factory RelativetimeformatterResponse.fromJson(Map<String, dynamic> json) => RelativetimeformatterResponse(
    status: json['status'] as String? ?? '',
    error: json['error'],
    data: json['data'] != null ? RelativetimeformatterData.fromJson(json['data']) : null,
    premium: json['premium'] != null ? PremiumInfo.fromJson(json['premium']) : null,
  );

  Map<String, dynamic> toJson() => {
    'status': status,
    if (error != null) 'error': error,
    if (data != null) 'data': data,
    if (premium != null) 'premium': premium!.toJson(),
  };
}

/// Describes fields the current plan does not unlock. Locked fields arrive as null
/// in [data], and [lockedFields] names them (nested ones use dot paths).
class PremiumInfo {
  final String? message;
  final String? upgradeUrl;
  final List<String>? lockedFields;

  PremiumInfo({this.message, this.upgradeUrl, this.lockedFields});

  factory PremiumInfo.fromJson(Map<String, dynamic> json) => PremiumInfo(
    message: json['message'] as String?,
    upgradeUrl: json['upgrade_url'] as String?,
    lockedFields: (json['locked_fields'] as List?)?.map((e) => e.toString()).toList(),
  );

  Map<String, dynamic> toJson() => {
    if (message != null) 'message': message,
    if (upgradeUrl != null) 'upgrade_url': upgradeUrl,
    if (lockedFields != null) 'locked_fields': lockedFields,
  };
}

/// Response data for the Relative Time Formatter API.

class RelativetimeformatterData {
  String? targetDate;
  String? referenceDate;
  String? relativeTime;
  bool? isPast;
  bool? isFuture;
  num? differenceMs;
  String? primaryUnit;
  num? primaryValue;
  RelativetimeformatterDataAllUnits? allUnits;
  String? style;

  RelativetimeformatterData({
    this.targetDate,
    this.referenceDate,
    this.relativeTime,
    this.isPast,
    this.isFuture,
    this.differenceMs,
    this.primaryUnit,
    this.primaryValue,
    this.allUnits,
    this.style,
  });

  factory RelativetimeformatterData.fromJson(Map<String, dynamic> json) => RelativetimeformatterData(
      targetDate: json['target_date'],
      referenceDate: json['reference_date'],
      relativeTime: json['relative_time'],
      isPast: json['is_past'],
      isFuture: json['is_future'],
      differenceMs: json['difference_ms'],
      primaryUnit: json['primary_unit'],
      primaryValue: json['primary_value'],
      allUnits: json['all_units'] != null ? RelativetimeformatterDataAllUnits.fromJson(json['all_units']) : null,
      style: json['style'],
    );
}

class RelativetimeformatterDataAllUnits {
  num? years;
  num? months;
  num? weeks;
  num? days;
  num? hours;
  num? minutes;
  num? seconds;
  num? milliseconds;

  RelativetimeformatterDataAllUnits({
    this.years,
    this.months,
    this.weeks,
    this.days,
    this.hours,
    this.minutes,
    this.seconds,
    this.milliseconds,
  });

  factory RelativetimeformatterDataAllUnits.fromJson(Map<String, dynamic> json) => RelativetimeformatterDataAllUnits(
      years: json['years'],
      months: json['months'],
      weeks: json['weeks'],
      days: json['days'],
      hours: json['hours'],
      minutes: json['minutes'],
      seconds: json['seconds'],
      milliseconds: json['milliseconds'],
    );
}

class RelativetimeformatterRequest {
  String timestamp;
  String? reference;
  String? style;

  RelativetimeformatterRequest({
    required this.timestamp,
    this.reference,
    this.style,
  });

  Map<String, dynamic> toJson() => {
      'timestamp': timestamp,
      if (reference != null) 'reference': reference,
      if (style != null) 'style': style,
    };
}
