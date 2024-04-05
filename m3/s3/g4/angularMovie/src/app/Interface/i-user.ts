import { IMovie } from './i-movie';

export interface IUser {
  id: number;
  name: string;
  email: string;
  password?: string;

  favourites?: IMovie[];
}
