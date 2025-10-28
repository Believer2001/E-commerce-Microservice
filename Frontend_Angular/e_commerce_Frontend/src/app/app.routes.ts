import { Routes } from '@angular/router';
import { Customers } from './customers/customers';
import { Inventory } from './inventory/inventory';
import { Billing } from './billing/billing';

export const routes: Routes = [
    { path: 'customers', component: Customers },
    { path: 'inventory', component: Inventory },
    { path: 'billing', component: Billing },
];
