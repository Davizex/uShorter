import { HttpHeaders } from "@angular/common/http";

export class HttpHeadersUtils {

    public static getHeaders(contentype: string = 'application/json; charset=utf-8'): HttpHeaders {
        return new HttpHeaders({
            'Content-Type': contentype,
            'Accept-Language' : 'pt-BR,pt;q=0.9',
            Accept: 'application/json, text/plain, */*',
        });
    }
}


