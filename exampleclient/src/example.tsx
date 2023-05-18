/** @jsx jsx */

import { jsx } from '@emotion/react';
import { token } from '@atlaskit/tokens';
import {
  Content,
  LeftSidebarWithoutResize,
  Main,
  PageLayout
} from '@atlaskit/page-layout';
import Heading from '@atlaskit/heading';


import { SlotLabel, SlotWrapper } from './components';

function ExampleApp() {
  return (
    <div className="ExampleApp">
      <header className="ExampleApp-header">
      <PageLayout>
        <Content testId="content">
        {
          <LeftSidebarWithoutResize testId="leftSidebar" id="space-nav" skipLinkTitle="Navigation" isFixed={false} width={200}>
            <SlotWrapper borderColor={token('color.border.accent.green', 'darkgreen')} hasExtraPadding>
              <SlotLabel isSmall>'Space Navigation</SlotLabel>
            </SlotWrapper>
          </LeftSidebarWithoutResize>
        }
        {
          <Main testId="main" id="main" skipLinkTitle="Main Content">
            <SlotWrapper borderColor={token('color.border', 'blue')} minHeight={400}>

              <Heading level="h700">Examples</Heading>


              <button className="bg-green-500 shadow-lg shadow-gray-500/50 ...">Subscribe</button>
              <p>
                Visit the first focusable element on the page to see the skip links menu
              </p>
            </SlotWrapper>
          </Main>
        }
        </Content>
      </PageLayout>
      </header>
    </div>
  );
}

export default ExampleApp;