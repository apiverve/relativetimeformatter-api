declare module '@apiverve/relativetimeformatter' {
  export interface relativetimeformatterOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface relativetimeformatterResponse {
    status: string;
    error: string | null;
    data: RelativeTimeFormatterData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface RelativeTimeFormatterData {
      targetDate:    Date | null;
      referenceDate: Date | null;
      relativeTime:  null | string;
      isPast:        boolean | null;
      isFuture:      boolean | null;
      differenceMS:  number | null;
      primaryUnit:   null | string;
      primaryValue:  number | null;
      allUnits:      AllUnits;
      style:         null | string;
  }
  
  interface AllUnits {
      years:        number | null;
      months:       number | null;
      weeks:        number | null;
      days:         number | null;
      hours:        number | null;
      minutes:      number | null;
      seconds:      number | null;
      milliseconds: number | null;
  }

  export default class relativetimeformatterWrapper {
    constructor(options: relativetimeformatterOptions);

    execute(callback: (error: any, data: relativetimeformatterResponse | null) => void): Promise<relativetimeformatterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: relativetimeformatterResponse | null) => void): Promise<relativetimeformatterResponse>;
    execute(query?: Record<string, any>): Promise<relativetimeformatterResponse>;
  }
}
