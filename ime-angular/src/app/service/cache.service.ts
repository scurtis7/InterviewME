import { Injectable } from '@angular/core';

enum CacheKey {
  SELECTED_CATEGORY = 'ime.selectedCategory',
}

@Injectable({
  providedIn: 'root'
})
export class CacheService {

  constructor() { }


  private setCacheObject = <T>(key: string, value: T): void => {
    localStorage.setItem(key, JSON.stringify(value));
  }

  setSelectedCategory(value: string) {
    this.setCacheString(CacheKey.SELECTED_CATEGORY, value);
  }

  getSelectedCategory(): string {
    return localStorage.getItem(CacheKey.SELECTED_CATEGORY) ?? "";
  }

  private setCacheString = (key: string, value: string): void => {
    localStorage.setItem(key, value);
  }

  private getCache = <T>(key: string): T | undefined => {
    try {
      const value = localStorage.getItem(key);
      if (value) {
        return JSON.parse(value) as T;
      } else {
        return undefined;
      }
    } catch (e) {
      console.error("Error while getting value from cache with key: " + key + "  " + e);
      return undefined;
    }
  };

}
