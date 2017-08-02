import { PopUpPage } from './app.po';

describe('pop-up App', () => {
  let page: PopUpPage;

  beforeEach(() => {
    page = new PopUpPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
