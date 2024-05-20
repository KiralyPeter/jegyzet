import { Kolcsonzesek } from "./kolcsonzesek";

export interface Kolcsonzok {
    id: number;
    nev: string;
    szulIdo: string;
    kolcsonzesek: Kolcsonzesek;
}
