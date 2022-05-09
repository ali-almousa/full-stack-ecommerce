import { Injector, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { HttpClientModule } from '@angular/common/http';
import { ProductService } from './services/product.service';

import { Routes, RouterModule, Router } from '@angular/router';
import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { SearchComponent } from './components/search/search.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CartStatusComponent } from './components/cart-status/cart-status.component';
import { CartDetailsComponent } from './components/cart-details/cart-details.component';
import { CheckoutComponent } from './components/checkout/checkout.component';
import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './components/login/login.component';
import { LoginStatusComponent } from './components/login-status/login-status.component';
// import { OktaAuthModule, OKTA_CONFIG } from '@okta/okta-angular';
import {
  OKTA_CONFIG,
  OktaAuthModule,
  OktaCallbackComponent
} from '@okta/okta-angular';

import myAppConfig from './config/my-app-config';

const oktaConfig = Object.assign({
  onAuthRequired: (injector:any) => {
    const router = injector.get(Router);

    // Redirect the user to your custom login page
    router.navigate(['/login']);
  }
  
}, myAppConfig.oidc);

// define the routes for the application
// all instanciated components will go in place of router-outlet in
// the app.component.html file.
const routes: Routes = [
  {path: 'login/callback', component: OktaCallbackComponent},
  {path: 'login', component: LoginComponent},
  {path:'checkout', component: CheckoutComponent},
  {path:'cart-details', component: CartDetailsComponent},
  {path:'products/:id', component: ProductDetailsComponent},
  {path:'search/:keyword', component: ProductListComponent},
  {path:'category/:id/:name', component: ProductListComponent},
  {path:'category', component: ProductListComponent},
  {path:'products', component: ProductListComponent},
  {path:'', redirectTo:'/products', pathMatch:'full'},
  {path:'**', redirectTo:'/products', pathMatch:'full'}
]

// const oktaConfig = Object.assign({
//   onAuthRequired: (oktaAuth: any, injector: Injector) => {
//     const router = injector.get(Router);
//     router.navigate(['/login']);
//   }

// }, myAppConfig.oidc)

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductCategoryMenuComponent,
    SearchComponent,
    ProductDetailsComponent,
    CartStatusComponent,
    CartDetailsComponent,
    CheckoutComponent,
    LoginComponent,
    LoginStatusComponent
  ],
  imports: [
    // configure the router based on the routes
    RouterModule.forRoot(routes),
    BrowserModule,
    HttpClientModule,
    // exposes the exported declarations in NgbModule (classes, interfaces, constants...)
    // and make them available in the current module
    NgbModule,
    // add support fore reactive forms
    ReactiveFormsModule,
    OktaAuthModule
  ],
  // allow us to inject this service into other parts of our project
  providers: [ProductService, { provide: OKTA_CONFIG, useValue: oktaConfig }],
  bootstrap: [AppComponent]
})
export class AppModule { }
