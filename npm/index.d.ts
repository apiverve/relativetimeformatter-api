declare module '@apiverve/relativetimeformatter' {
  export interface relativetimeformatterOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface relativetimeformatterResponse {
    status: string;
    error: string | null;
    data: RelativeTimeFormatterData;
    code?: number;
  }


  interface RelativeTimeFormatterData {
      targetDate:    Date;
      referenceDate: Date;
      relativeTime:  string;
      isPast:        boolean;
      isFuture:      boolean;
      differenceMS:  number;
      primaryUnit:   string;
      primaryValue:  number;
      allUnits:      AllUnits;
      style:         string;
  }
  
  interface AllUnits {
      years:        number;
      months:       number;
      weeks:        number;
      days:         number;
      hours:        number;
      minutes:      number;
      seconds:      number;
      milliseconds: number;
  }

  export default class relativetimeformatterWrapper {
    constructor(options: relativetimeformatterOptions);

    execute(callback: (error: any, data: relativetimeformatterResponse | null) => void): Promise<relativetimeformatterResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: relativetimeformatterResponse | null) => void): Promise<relativetimeformatterResponse>;
    execute(query?: Record<string, any>): Promise<relativetimeformatterResponse>;
  }
}
