import { TestAngJS2Page } from './app.po';

describe('test-ang-js2 App', () => {
  let page: TestAngJS2Page;

  beforeEach(() => {
    page = new TestAngJS2Page();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
