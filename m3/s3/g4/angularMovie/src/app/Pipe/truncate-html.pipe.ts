import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'truncateHtml',
})
export class TruncateHtmlPipe implements PipeTransform {
  transform(value: string, maxLength: number): string {
    const strippedString = value.replace(/<[^>]*>/g, '');

    const truncatedString =
      strippedString.length > maxLength
        ? strippedString.substring(0, maxLength) + '...'
        : strippedString;

    const finalString = value.replace(strippedString, truncatedString);
    return finalString;
  }
}
