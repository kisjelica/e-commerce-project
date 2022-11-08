import { Injectable } from '@angular/core';
import { BehaviorSubject, Subject } from 'rxjs';
import { CartItem } from '../common/cart-item';

@Injectable({
  providedIn: 'root'
})
export class CartService {


  cartItems: CartItem[] = [];
  
  totalPrice: Subject<number> = new BehaviorSubject<number>(0);
  totalQuantity: Subject<number> = new BehaviorSubject<number>(0);

  storage: Storage = sessionStorage;

  constructor() {
    //read data from storage
    let data = JSON.parse(this.storage.getItem('cartItems'));
    if(data != null){
      this.cartItems = data;

      //compute totals based on data from storage
      this.computeCartTotals();
    }
   }

  persistCartItems(){
    this.storage.setItem('cartItems',JSON.stringify(this.cartItems));
  }

  addToCart(cartItem: CartItem) {
    //check if we already have the item in the cart
    let alreadyExistsInCart: boolean = false;
    let existingCartItem: CartItem = undefined;

    if (this.cartItems.length > 0) {
      //find the item based on id
      existingCartItem = this.cartItems.find(tempCartItem => tempCartItem.id === cartItem.id);
      //check if the given item is found
      alreadyExistsInCart = (existingCartItem != undefined);
    }

    if (alreadyExistsInCart) {
      existingCartItem.quantity++;
    } else {
      this.cartItems.push(cartItem);
    }

    this.computeCartTotals();
  }
  computeCartTotals() {
    let totalPriceValue: number = 0;
    let totalQuantityValue: number = 0;

    for (let currentCartItem of this.cartItems) {
      totalPriceValue += currentCartItem.quantity * currentCartItem.unitPrice;
      totalQuantityValue += currentCartItem.quantity;
    }

    //publish the new values for total price and qty
    this.totalPrice.next(totalPriceValue);
    this.totalQuantity.next(totalQuantityValue);

    this.persistCartItems();
  }

  decrementQuantity(cartItem: CartItem) {
    cartItem.quantity--;

    if (cartItem.quantity === 0) {
      this.remove(cartItem);
    } else {
      this.computeCartTotals();
    }
  }
  remove(cartItem: CartItem) {
    //get index of item in array
    const itemIndex = this.cartItems.findIndex(tempCartItem => tempCartItem.id === cartItem.id);

    //if found, remove at given index
    if (itemIndex > -1) {
      this.cartItems.splice(itemIndex, 1);

      this.computeCartTotals();
    }
  }
}
